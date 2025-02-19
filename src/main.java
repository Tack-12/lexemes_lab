public class main {
    public static void main(String[] args) {

        String output= "123";
        String s = "";
        stringcode filereader = new stringcode();
        formattingString commentremoved = new formattingString();
        tokenizing tokenizer = new tokenizing();
        filereader.set_filename("src/Codes/SquareGame.jack");

        output = filereader.read_line();
        s= commentremoved.removeComments(output);
        s=tokenizer.tokenizeJackCode(s);


        //System.out.print(output);
        System.out.println(s);
    }
}
