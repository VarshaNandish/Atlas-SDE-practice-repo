import java.io.*;

class Task20
{
    public static void main(String args[])
    {
        try
        {
            byte b=0;
            FileInputStream infile = new FileInputStream("FileName02.txt");
            FileOutputStream outfile = new FileOutputStream("NewFile02.txt");
            int byteread = 0;
            while(byteread != -1)
            {
                b = (byte)infile.read();
                outfile.write(b);
            }
            System.out.println("Byte Copied From in.txt to out.txt FIle ");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Sorry..!! File Not Found...!!!");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
