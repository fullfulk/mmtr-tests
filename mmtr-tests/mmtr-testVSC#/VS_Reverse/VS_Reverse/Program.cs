using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using VS_Reverse.reverse;

namespace VS_Reverse
{
    class Program
    {
        private static void outLine(byte[] a)
        {
            string s = string.Empty;
            foreach (byte b in a)
            {
                s += b+" ";
            }
            Console.WriteLine(s);
        }

        static void Main(string[] args)
        {
            byte[] input = new byte[4] { 35,32,34,12};
            Console.WriteLine("original: "+string.Join(",",input));

            byte[] outputA = Reverse.reverseA(input);
            Console.WriteLine("reverse A: " + string.Join(",", outputA));

            byte[] outputB = Reverse.reverseB(input);
            Console.WriteLine("reverse B: " + string.Join(",", outputB));

            Console.ReadKey();
        }
    }
}
