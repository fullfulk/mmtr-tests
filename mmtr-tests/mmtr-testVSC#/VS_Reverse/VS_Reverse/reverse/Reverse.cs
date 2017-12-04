using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VS_Reverse.reverse
{
    public class Reverse
    {
        public static byte[] reverseA(byte[] input)
        {
            byte[] output = new byte[input.Length];
            for (int i = 0; i < input.Length; i++)
            {
                BitArray bitArr = new BitArray(new byte[1] { input[i] });
                bool[] revbits = new bool[8];
                bitArr.CopyTo(revbits, 0);
                bitArr = new BitArray(revbits.Reverse().ToArray());
                byte[] b = new byte[1];
                bitArr.CopyTo(b,0);
                output[i] = b[0];
            }
            return output;
        }

        public static byte[] reverseB(byte[] input)
        {
            List<byte> output = new List<byte>();
            foreach (byte b in input)
            {
                output.Add(byteReverse(b));
            }
            return output.ToArray();
        }

        private static byte byteReverse(byte b)
        {
            byte tmp = 0;
            for (int i = 7; i >=0; i--)
            {
                tmp += (byte)((b & 1) << i);
                b >>= 1;
            }
            return tmp;
        }
    }
}
