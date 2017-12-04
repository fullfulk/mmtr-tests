using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using UserTest.userTests;

namespace UserTest
{
    class Program
    {
        private static Repository repository = new Repository();
        private static bool isWork=true;
        private static void onAdd(int timeOut,object locker)
        {
            while (isWork)
            {
                repository.addUser(new User(genName(locker),genAge(locker)));
                Thread.Sleep(timeOut);
            }
        }

        private static void onGet(int timeOut)
        {
            Random rnd = new Random();
            while (isWork)
            {
                int id = Repository .showID();
                Console.WriteLine(repository.getUser(rnd.Next(1,id)));
                Thread.Sleep(timeOut);
            }
        }

        private static void onGetRepository(int timeOut)
        {
            while (isWork)
            {
                repository.getOrderedUsers();
                Thread.Sleep(timeOut);
            }
        }
        private static int genAge(object locker)
        {
            int age = 0;
            lock (locker)
            {
                age = new Random().Next(18, 101);
            }
            return age;
        }

        private static string genName(object locker)
        {
            string name = string.Empty;
            string hub = "qwertyuioplkjhgfdsazxcvbnm";
            Random rnd;
            lock (locker)
            {
                for (int i = 0; i < 4; i++)
                {
                    rnd = new Random();
                    name += hub[rnd.Next(0, hub.Length - 1)];
                }
            }
            return Thread.CurrentThread.Name+":"+name;
        }

        static void Main(string[] args)
        {
            Thread exe01 = new Thread(()=>onAdd(300,new object()));
            Thread exe11 = new Thread(() => onAdd(300,new object()));
            //Thread exe02 = new Thread(() => onGet(4000));
            Thread exe03 = new Thread(() => onGetRepository(5000));
            exe01.Name = "add01";
            exe11.Name = "add02";
            //exe02.Name = "get user";
            exe03.Name = "get repository";
            exe01.Start();
            exe11.Start();
            Thread.Sleep(300);
            //exe02.Start();
            Thread.Sleep(300);
            exe03.Start();
            Console.ReadKey();
            isWork = false;
        }

       
    }
}
