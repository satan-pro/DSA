import java.util.*;
public class lc71 {
        public String simplifyPath(String path) {
            Stack<String> st = new Stack<>();
            String res = new String();
            String arr[] = path.split("/");

            System.out.println(Arrays.toString(arr));
            for(int i=0; i<arr.length; i++)
            {
                System.err.println(arr[i]);
                if(!st.empty())
                {
                   if(arr[i].equals(".."))
                   {
                        st.pop();
                   }
                }
                else if(!arr[i].equals(".") && !arr[i].equals("..") && !arr[i].equals(""))
                {
                    st.push(arr[i]);
                }
            }

            System.out.println(st);

            while(!st.empty())
            {
                String s = st.pop();
                res+=s;
            }
            if(st.empty())
            {
                res="/"+res;
            }
            return res;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path : ");
        String str = sc.nextLine();
        
        lc71 obj = new lc71();
        String res = obj.simplifyPath(str);
        System.out.println(res);
    }
}
