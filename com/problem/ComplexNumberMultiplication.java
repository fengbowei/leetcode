
class Solution {   
    public int[] stringToNumber(String s)
    {
        int[] num = new int[2];
        if(s.indexOf("+") == -1)
        {
            s = s.substring(0, s.lastIndexOf("-")) + "+" + s.substring(s.lastIndexOf("-"), s.length() - 1);
        }
        String result[] = s.split("\\+");
        result[1] = result[1].replace("i", "");      
        num[0] = Integer.valueOf(result[0]);
        num[1] = Integer.valueOf(result[1]);
        
        return num;
    }
    
    public String complexNumberMultiply(String a, String b) {
        int[] numa = stringToNumber(a);
        int[] numb = stringToNumber(b);
        
        int[] tmp = new int[4];
        tmp[0] = numa[0] * numb[0];
        tmp[1] = numa[0] * numb[1];
        tmp[2] = numa[1] * numb[0];
        tmp[3] = numa[1] * numb[1];
        
        int r = tmp[0] - tmp[3];
        int i = tmp[1] + tmp[2];
        
        String result = new String();
        result = result.format("%d+%di", r, i);
        return result;
    }
}
