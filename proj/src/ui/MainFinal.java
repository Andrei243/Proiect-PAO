package ui;

public class MainFinal {

    public static void main(String[] args){
        Thread threadSwing=new Thread( ()->{
            MainSwing.main(args);
        } );
        Thread threadCLI=new Thread( ()->{
            MainCLI.main(args);
        } );
        threadSwing.run();
        threadCLI.run();
        try{
            threadCLI.join();
        }
        catch(Exception e){

        }
        try{
            threadSwing.join();

        }catch(Exception e){

        }


    }

}
