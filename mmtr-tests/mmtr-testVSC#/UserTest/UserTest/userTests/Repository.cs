using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace UserTest.userTests
{
    public class Repository
    {
        private volatile ConcurrentDictionary<int, User> storage = new ConcurrentDictionary<int, User>();
        private static volatile int lastID = 0;
        public static int getID()
        {
            return Interlocked.Increment(ref lastID);
        }

        public void addUser(User user)
        {
            if (!storage.TryAdd(user.id, user))
            {
                throw new Exception("invalid id");
            }
        }
        public User getUser(int id)
        {
            User outU;
            if (!storage.TryGetValue(id, out outU))
            {
                throw new Exception("invalid id");
            }
            return outU;
        }

        public void getOrderedUsers()
        {
            foreach (var usr in storage)
            {
                Console.WriteLine(usr.Key+" "+usr.Value);
            }
        }
    }
}
