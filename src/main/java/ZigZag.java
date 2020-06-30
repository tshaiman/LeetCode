
public class ZigZag {

    public static void main(String[] args) {
        ZigZag z = new ZigZag();
        System.out.println(z.convert("PAYPALISHIRING",4));
    }


    public String convert(String s, int numRows) {
        int zigDim = numRows -2 ;
        int cols = (int)(s.length() / (double)(numRows + zigDim) * (1+zigDim));
        char[][] matrix = new char[numRows][cols];
        int nextCharIndex = 0;
        for (int i=0 ; i < cols ; ++ i) {
            if (i % (zigDim+1) == 0) {
                nextCharIndex = fillCol(s,matrix,i,numRows,nextCharIndex);
            }
            else {
                nextCharIndex ++;
            }
        }
        return "";
    }

    private int fillCol(String s, char[][] matrix, int col, int rows, int nextCharIndex) {
        for (int i=0 ; i < rows ; ++i) {
            if (nextCharIndex >= s.length())
                break;
            matrix[i][col] = s.charAt(nextCharIndex);
            nextCharIndex ++ ;
        }
        return nextCharIndex;
    }
}
