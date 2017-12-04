using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UserTest.userTests
{

    public class User
    {
        public string name { get; private set; }
        public int id { get; private set; }
        public int age { get; private set; }
        public User(string name,int age)
        {
            this.id = Repository.getID();
            this.name = name;
            this.age = age;
        }
        public override string ToString()
        {
            return string.Join(":",new string[] { id.ToString(),name,age.ToString()});
        }
    }
}
