import java.util.*;

class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {

        int wordPtr=0;
        int abbrPtr=0;

        while(wordPtr< word.length() && abbrPtr<abbr.length()){

             if(Character.isDigit(abbr.charAt(abbrPtr))){

                if(abbr.charAt(abbrPtr)=='0'){
                    return false;
                }
                     int num=0;

                    while(abbrPtr<abbr.length() && Character.isDigit(abbr.charAt(abbrPtr))){
                        num=(num*10)+(abbr.charAt(abbrPtr)-'0');
                        abbrPtr++;
                    }
                    wordPtr=wordPtr+num;
                    continue;
                } 

            if(word.charAt(wordPtr)==abbr.charAt(abbrPtr)){
                abbrPtr++;
                wordPtr++;
            }
            else{
                return false;                
            }

        }


        if(abbrPtr==abbr.length() && wordPtr==word.length()){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        ValidWordAbbreviation vwa = new ValidWordAbbreviation();
        String word = "internationalization";
        String abbr = "i12iz4n";
        boolean result = vwa.validWordAbbreviation(word, abbr);
        System.out.println("Is the abbreviation valid? " + result);
    }

}