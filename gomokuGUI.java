import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import gomoku.gomoku_terminal;

public class gomokuGUI extends JFrame{
  JButton button[][];
  JLabel turn_label;
  JLabel judge_label;
  int turn = 0;
  int jj = 0;


  public static void main(String[] args){
    // フレームのインスタンス生成
    gomokuGUI frame = new gomokuGUI();
    // 閉じた時に終了するアプリケーション
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 座標と幅高さを指定setBounds(int x, int y, int width, int height)
    frame.setBounds(10, 10, 600, 500);
    frame.setTitle("五目並べ");
    // フレームが表示される
    frame.setVisible(true);
  }

  gomokuGUI(){
    // ボタンの生成
    // 配列は宣言せず、ボタンを宣言する時に変数を配列にすれば配列になる
    button = new JButton[19][19];

    ButtonActionListener btn_act = new ButtonActionListener();

    for(int y = 0;y < button.length; y++){ 
      for(int x = 0;x <button[y].length; x++){
        button[y][x] = new JButton("");
        button[y][x].addActionListener(btn_act);
      }
    }


    turn_label = new JLabel("●の番です");
    judge_label = new JLabel("");

    // パネルを生成
    JPanel up_p = new JPanel();
    JPanel p = new JPanel();
    JPanel down_p = new JPanel();
    // パネルのレイアウト決める今回は１９＊１９のグリッドにした
    up_p.setLayout(new GridLayout(1,1));
    p.setLayout(new GridLayout(19, 19));


    up_p.add(turn_label);
    down_p.add(judge_label);
    
    // パネルに一気に生成したボタンを追加していく
    for (int y = 0; y < button.length; y++) {
      for (int x = 0; x < button[y].length; x++) {
        p.add(button[y][x]);

      } 
    }

    // ちょっと謎後で調べる
    getContentPane().add(up_p, BorderLayout.NORTH);
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(down_p, BorderLayout.SOUTH);
  }
  class ButtonActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      // イベント情報取得
      JButton btn = (JButton)e.getSource();

      if(turn == 0){
        btn.setText("●");
        btn.setEnabled(false);    
        turn++;
        turn_label.setText("Xの出番です。");
      }
      else{
        btn.setText("X");
        btn.setEnabled(false);
        turn=0;
        turn_label.setText("●の出番です。");
      }
      // ボタンを押した座標再取得
      for (int y = 0; y < button.length; y++) {
        for (int x = 0; x < button[y].length; x++) {
          if(btn == button[y][x]){

            gomoku_terminal gt;
            gt = new gomoku_terminal(x,y,turn);
            jj = gt.gomoku_play();
            if(jj == 1){
              judge_label.setText("●の勝ち！！");
              button_false();
            }
            else if(jj == 2){
              judge_label.setText("Xの勝ち！！");
              button_false();

            }
            else if(jj == 3){
              judge_label.setText("引き分け！！");
              button_false();

            }
          }
        }
      }

      
    }
  }
  void button_false(){
    for(int y = 0;y < button.length; y++){ 
      for(int x = 0;x <button[y].length; x++){
        button[y][x].setEnabled(false);
      }
    }
  }
}