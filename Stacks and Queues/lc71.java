import java.util.*;
public class lc71 {
        public String simplifyPath(String path) {
            Stack<String> st = new Stack<>();
            String arr[] = path.split("/");

            for(String s: arr)
            {
                if(s.equals(".")||s.equals(""))
                    continue;
                else if(s.equals(".."))
                {
                    if(!st.isEmpty())
                        st.pop();
                }
                else 
                    st.push(s);
            }

            StringBuilder ans = new StringBuilder("");
            while(!st.isEmpty())
            {
                ans.insert(0, st.pop());
                ans.insert(0, "/");
            }
            
            if(ans.isEmpty())
                ans.append("/");

            return ans.toString();
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
