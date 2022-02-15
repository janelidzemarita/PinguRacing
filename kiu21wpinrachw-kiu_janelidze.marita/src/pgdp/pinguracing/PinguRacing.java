package pgdp.pinguracing;

import static pgdp.MiniJava.*; // Do not delete this import!

public class PinguRacing {
    public static void main(String[] args) {
        int[] speed = new int[2];
        int[] position = new int[2];
        position[0] = readInt("Alan starting position:");
        position[1] = readInt("Bjarne starting position:");
        int t = readInt("Race duration:");
        while (t < 0){
            t = readInt("Please do not enter a negative number:");
        }
        speed[0] = 0;
        speed[1] = 0;
        for (int i = 0; i < t/2; i++ ){
            if (position[0] % 10 == 4 && speed[0] <= 128){
                speed[0] = (speed[0]/2) + 1;
                position[0] += speed[0];
            }else if (speed[0] <= 128) {
                speed[0] += 7;
                position[0] += speed[0];
            }else{
                speed[0] = 128;
                position[0] += speed[0];
                }

            if(position[1] % 13 == 0 && speed[1] <= 128){
                speed[1] = (speed[1] * 2) + 1;
                position[1] += speed[1];
            }else if(speed[1] <= 128){
                speed[1] += 3;
                position[1] += speed[1];
            }else{
                speed[1] = 128;
                position[1] += speed[1];
            }
            write("t = " + (i));
            write("Alan position = " + position[0] + "; speed = " + speed[0]);
            write("Bjarne position = " + position[1] + "; speed = " + speed[1]);
            }
        for (int i = (t/2); i < t; i++){
            if (((t*3)/5 == i || (t*4)/5 == i) && speed[0] >= 0){
                speed[0] = speed[0] / 4;
                position[0] += speed[0];
            }else if(speed[0] >= 0) {
                speed[0] += 1;
                position[0] += speed[0];
            }else{
                speed[0] = 0;
                position[0] += speed[0];
            }
            if (i >= t - 13 && speed[1] >= 0){
                speed[1] = speed[1] / 2;
                position[1] += speed[1];
            }else if(speed[1] >= 0){
                speed[1] -= 1;
                position[1] += speed[1];
            }else{
                speed[1] = 0;
                position[1] += speed[1];
            }
            write("t = " + (i));
            write("Alan position = " + position[0] + "; speed = " + speed[0]);
            write("Bjarne position = " + position[1] + "; speed = " + speed[1]);
        }
        if (position[0] > position[1]){
            write("Alan wins!");
        }else if(position[1] > position[0]){
            write("Bjarne wins!");
        }else{
            write("Draw!");
        }

        }
}
