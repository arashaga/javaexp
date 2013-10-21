/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexperiment;

/**
 *
 * @author arash
 */
public class SpinnerRunnable extends Thread {

    private int a;
   

    @Override
    public void run() {



        for (int i = 0; i < 10; i++) {
            //  if (jButton1.getText().equalsIgnoreCase("Stop")) break;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setValue(i);

        }


    }



    public void setValue(int a) {
        // if value has changed notify observers
        this.a = a;

        }
    public int getValue(){
    
    return this.a;
    }


}
