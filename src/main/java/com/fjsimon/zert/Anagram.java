package com.fjsimon.zert;

public class Anagram
{
    static void isAnagram(String s1, String s2)
    {
        //Removing white spaces from s1 and s2 and converting case to lower

        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();

        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

        //Initially setting status as true

        boolean status = true;

        if(copyOfs1.length() != copyOfs2.length()) {

            status = false;
        } else {

            char[] s1Array = copyOfs1.toCharArray();

            StringBuilder sb = new StringBuilder(copyOfs2);

            for (char c : s1Array) {
                int index = sb.indexOf(""+c);

                if (index != -1) {

                    sb = sb.deleteCharAt(index);
                } else {

                    status = false;
                    break;
                }
            }
        }

        //Output

        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }

    public static void main(String[] args)
    {
        isAnagram("Mother In Law", "Hitler Woman");

        isAnagram("keEp", "peeK");

        isAnagram("SiLeNt CAT", "LisTen AcT");

        isAnagram("Debit Card", "Bad Credit");

        isAnagram("School MASTER", "The ClassROOM");

        isAnagram("DORMITORY", "Dirty Room");

        isAnagram("ASTRONOMERS", "NO MORE STARS");

        isAnagram("Toss", "Shot");

        isAnagram("joy", "enjoy");
    }
}
