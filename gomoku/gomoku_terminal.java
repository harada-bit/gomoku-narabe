package gomoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





public class gomoku_terminal{
    // # 初期値
    static int[][] field = new int[19][19];
    static int[][] col_list = new int[19][19];
    static int[][] row_list = new int[19][19];
    static int[][] crossL_List = new int[19][19];
    static int[][] crossL_List_xSlide = new int[19][19];
    static int[][] crossL_List_ySlide = new int[19][19];
    static int[][] crossR_List_xSlide = new int[19][19];
    static int[][] crossR_List_ySlide = new int[19][19];
    static int[][] crossR_List = new int[19][19];
    int x;
    int y;
    int turn;

    public gomoku_terminal(int xza, int yza, int tn){
        x = xza;
        y = yza;
        turn = tn;
    }


    public int gomoku_play(){

            if(turn == 1) {
                field[y][x] = 1;
            }

            if(turn == 0) {
                field[y][x] = 2;
            }
            field_data();

            int pack = 0;
                        
            pack = pack_pro();
            if (0 < pack && pack < 4){
                return pack;
            }    
            
        return 0;
    }



    //*********************************************
    //     OK!!
    //*********************************************
    // フィールドデータ表示
    public static void field_data(){
        for (int[] lis:field){
            System.out.println(Arrays.toString(lis));
        }
        System.out.print("\n");
    }


    // # 【関数】勝敗判定    
    public static int judge(){
        int pl = 0;
        int cp = 0;
        // # 左斜リスト

        //---------------------------------------------
        //     OK(左斜ジャッジ)
        //---------------------------------------------
        
        for (int[] crl_xlis:crossL_List_xSlide){
            pl = 0;
            cp = 0;
            // 0がNONE、１がプレイヤー、２がCPU
            for (int i = 0; i < crl_xlis.length; i++) {
                if(crl_xlis[i] == 1){
                    pl++;
                    for (int j = i+1; j < crl_xlis.length; j++) {
                        if(crl_xlis[j] == 1){
                            pl++;
                            if (pl==5){
                                System.out.println("左斜あなたの勝ち");
                                return 1;
                            }
                        }
                        else {
                            pl = 0;
                            break;
                        }
                    }
                }
                if(crl_xlis[i] == 2){
                    cp++;
                    for (int j = i+1; j < crl_xlis.length; j++) {
                        if(crl_xlis[j] == 2){
                            cp++;
                            if (cp==5){
                                System.out.println("左斜あなたの負け");
                                return 2;
                            }
                        }
                        else {
                            cp = 0;
                            break;
                        }
                    }
                }
            }
        }
        for (int[] crl_ylis:crossL_List_ySlide){
            pl = 0;
            cp = 0;
            // 0がNONE、１がプレイヤー、２がCPU
            for (int i = 0; i < crl_ylis.length; i++) {
                if(crl_ylis[i] == 1){
                    pl++;
                    for (int j = i+1; j < crl_ylis.length; j++) {
                        if(crl_ylis[j] == 1){
                            pl++;
                            if (pl==5){
                                System.out.println("左斜あなたの勝ち");
                                return 1;
                            }
                        }
                        else {
                            pl = 0;
                            break;
                        }
                    }
                }
                if(crl_ylis[i] == 2){
                    cp++;
                    for (int j = i+1; j < crl_ylis.length; j++) {
                        if(crl_ylis[j] == 2){
                            cp++;
                            if (cp==5){
                                System.out.println("左斜あなたの負け");
                                return 2;
                            }
                        }
                        else {
                            cp = 0;
                            break;
                        }
                    }
                }
            }
        }






        //---------------------------------------------
        //     OK(/ # 右斜リスト)
        //---------------------------------------------
        for (int[] crr_xlis:crossR_List_xSlide){
            pl = 0;
            cp = 0;
            // 0がNONE、１がプレイヤー、２がCPU
            for (int i = 0; i < crr_xlis.length; i++) {
                if(crr_xlis[i] == 1){
                    pl++;
                    for (int j = i+1; j < crr_xlis.length; j++) {
                        if(crr_xlis[j] == 1){
                            pl++;
                            if (pl==5){
                                System.out.println("右斜あなたの勝ち");
                                return 1;
                            }
                        }
                        else {
                            pl = 0;
                            break;
                        }
                    }
                }
                if(crr_xlis[i] == 2){
                    cp++;
                    for (int j = i+1; j < crr_xlis.length; j++) {
                        if(crr_xlis[j] == 2){
                            cp++;
                            if (cp==5){
                                System.out.println("右斜あなたの負け");
                                return 2;
                            }
                        }
                        else {
                            cp = 0;
                            break;
                        }
                    }
                }
            }
        }
        for (int[] crr_ylis:crossR_List_ySlide){
            pl = 0;
            cp = 0;
            // 0がNONE、１がプレイヤー、２がCPU
            for (int i = 0; i < crr_ylis.length; i++) {
                if(crr_ylis[i] == 1){
                    pl++;
                    for (int j = i+1; j < crr_ylis.length; j++) {
                        if(crr_ylis[j] == 1){
                            pl++;
                            if (pl==5){
                                System.out.println("右斜あなたの勝ち");
                                return 1;
                            }
                        }
                        else {
                            pl = 0;
                            break;
                        }
                    }
                }
                if(crr_ylis[i] == 2){
                    cp++;
                    for (int j = i+1; j < crr_ylis.length; j++) {
                        if(crr_ylis[j] == 2){
                            cp++;
                            if (cp==5){
                                System.out.println("右斜あなたの負け");
                                return 2;
                            }
                        }
                        else {
                            cp = 0;
                            break;
                        }
                    }
                }
            }
        }









        pl = 0;
        cp = 0;
        
        // # 右斜リスト

        //*********************************************
        //     OK!!
        //*********************************************
        // # 列リスト
        for (int[] col_lis:col_list){
            pl = 0;
            cp = 0;
            // 0がNONE、１がプレイヤー、２がCPU
            for (int i = 0; i < col_lis.length; i++) {
                if(col_lis[i] == 1){
                    pl++;
                    for (int j = i+1; j < col_lis.length; j++) {
                        if(col_lis[j] == 1){
                            pl++;
                            if (pl==5){
                                System.out.println("列あなたの勝ち");
                                return 1;
                            }
                        }
                        else {
                            pl = 0;
                            break;
                        }
                    }
                }
                if(col_lis[i] == 2){
                    cp++;
                    for (int j = i+1; j < col_lis.length; j++) {
                        if(col_lis[j] == 2){
                            cp++;
                            if (cp==5){
                                System.out.println("列あなたの負け");
                                return 2;
                            }
                        }
                        else {
                            cp = 0;
                            break;
                        }
                    }
                }
            }
        }


        //*********************************************
        //     OK!!
        //*********************************************
        // # 行リスト
        for (int[] row_lis:row_list){
            pl = 0;
            cp = 0;
            // 0がNONE、１がプレイヤー、２がCPU
            for (int i = 0; i < row_lis.length; i++) {
                if(row_lis[i] == 1){
                    pl++;
                    for (int j = i+1; j < row_lis.length; j++) {
                        if(row_lis[j] == 1){
                            pl++;
                            if (pl==5){
                                System.out.println("行あなたの勝ち");
                                return 1;
                            }
                        }
                        else {
                            pl = 0;
                            break;
                        }
                    }
                }
                if(row_lis[i] == 2){
                    cp++;
                    for (int j = i+1; j < row_lis.length; j++) {
                        if(row_lis[j] == 2){
                            cp++;
                            if (cp==5){
                                System.out.println("行あなたの負け");
                                return 2;
                            }
                        }
                        else {
                            cp = 0;
                            break;
                        }
                    }
                }
            }
        }
    // ジャッジ0
    return 0;
    }



    // # 【関数】行列斜めリストデータリスト構築
    public static void list_data(){
        int y = 0;
        int x = 0;
        for (int[] row_lis : field){
            // 行と列の配列構築
            //*********************************************
            //     OK!!
            //*********************************************
            for(int cell : row_lis){
                col_list[x][y] = cell;
                row_list[y][x] = cell;
                x++;
            }
            x=0;
            y++;
        }
        x = 0;
        y = 0;
            // 右斜めリスト行の配列の０番目から長さの−５（１３）までスタートした長さと
            // 右斜リスト列の１番めから長さ−５までの（１３）を取得したリストが右斜リスト
        
    
        //*********************************************
        //     OK!!
        //*********************************************
        // 次の斜め取得
        for(int i = 0;i < 13; i++){
            for(int[]row_lis : field){
                for (int cell : row_lis){
                    if(x+i == y){
                        crossL_List_xSlide[i][y]=cell;
                    }
                    if(x == y+i){
                        crossL_List_ySlide[i][y]=cell;
                    }
                    x++;
                }
                x=0;
                y++;
            }
            x = 0;
            y = 0;
        }
        x = 0;
        y = 0;
        


        
        for(int i = 0;i < 13; i++){
            for(int[]row_lis : field){
                for (int cell : row_lis){
                    if(x+i == 18-y){
                        // ok
                        crossR_List_xSlide[i][y]=cell;
                    }
                    if(x == 18-y+i){
                        crossR_List_ySlide[i][y]=cell;
                    }
                    x++;
                }
                x=0;
                // xk--;
                y++;
            }
            x = 0;
            y = 0;
        }
    }
    
        
        // 斜め取得

                // 斜めリスト行の配列の０番目から長さの−５（１３）までスタートした長さと
                // 右斜リスト列の１番めから長さ−５までの（１３）を取得したリストが右斜リスト
                


    //*********************************************
    //     OK!!
    //*********************************************
    // # 【関数】ループを抜ける
    public static int exit_judge(){
        int j = 0;
        int k = 0;
        for (int[] row_lis : field){
            for (int cell : row_lis){
                if(cell != 0) j++;
            }
            if (j == 18){
                k++;
            }
            j = 0;
        }
        if (k == 18){
            System.out.println("引き分けです");
            return 3;
        }
    return 0;
    }
    

    //*********************************************
    //     OK!!
    //*********************************************
    public static int pack_pro(){
        // field_data();
        list_data();
        int kekka = 0;
        int exit_kekka = 0;
        kekka = judge();
        if (kekka == 1)return 1;
        else if(kekka == 2)return 2; 
        exit_kekka = exit_judge();
        if (exit_kekka == 3)return 3;
    return 0;
    }
}