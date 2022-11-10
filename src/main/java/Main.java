import java.io.File;

public class Main {
    public static void main(String[] args) {
        getAllFiles("src", 0);
    }
    public static void getAllFiles (String dir, int deep){
        File fileDir = new File(dir);
        String listDir[] = fileDir.list();
        for(String directory : listDir){
            File file = new File(dir+"/"+directory);
            for (int i = 0; i < deep; i++) {
                if ((i == 0 && deep <= 1) || (i > 0 && i == deep - 1)) {
                    if (directory.equals(listDir[listDir.length - 1])) {
                        System.out.print("\u001B[37m"+" ╚══ "+"\u001B[0m");
                    } else {
                        System.out.print("\u001B[37m"+" ╠══ "+"\u001B[0m");
                    }
                } else {
                    if ((i == 0 && deep > 1) || (i > 0 && i < deep - 1)) {
                        if (isLastInCatalog(fileDir.getParent(), fileDir.getName())) {
                            System.out.print("\u001B[37m"+"     "+"\u001B[0m");
                        } else {
                            System.out.print("\u001B[37m"+" ║   "+"\u001B[0m");
                        }
                    }
                }
            }
            if (file.isFile())
                System.out.println("\u001B[36m"+directory+"\u001B[0m");
            if (file.isDirectory()) {
                System.out.println("\u001B[33m"+directory+"\u001B[0m");
                getAllFiles(dir+"/"+directory, deep+1);
            }
        }
    }
    private static boolean isLastInCatalog(String dir, String file){
        File fileDir = new File(dir);
        String listDir[] = fileDir.list();
        if(file.equals(listDir[listDir.length-1]))
            return true;
        return false;

    }
}