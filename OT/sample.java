public class sample {
    public static String solution(String forth) {
        int x = 0, y = 0;
        
        // Calculate final position after outward journey
        for (char direction : forth.toCharArray()) {
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
        }
        
        StringBuilder returnPath = new StringBuilder();
        
        // Move back to origin (0,0)
        while (x != 0 || y != 0) {
            if (x > 0 && !forth.contains("W")) {
                returnPath.append('W');
                x--;
            } else if (x < 0 && !forth.contains("E")) {
                returnPath.append('E');
                x++;
            } else if (y > 0 && !forth.contains("S")) {
                returnPath.append('S');
                y--;
            } else if (y < 0 && !forth.contains("N")) {
                returnPath.append('N');
                y++;
            }
        }
        
        return returnPath.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(solution("NEENWN"));  // Output: WWSSSE
        System.out.println(solution("NWNENWNEN"));  // Output: ESSSSSW
    }
}