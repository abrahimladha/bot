//Made by Abrahim Ladha
//HASHEMI AI PROJECT 4
import javafx.scene.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.util.*;
import java.io.*;
public class bot extends Application {
    static int[][] boardstate = 
    {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
    {0,0,0,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
    {0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
    {0,1,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
    {0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
    {0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
    {0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0},
    {0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}};
    static String FILE = "./rules.txt";
    static int x = 10;
    static int y = 19;
    static int goalx = 17;
    static int goaly = 0;
    static boolean yellowd = false;     
  static Rectangle robit = new Rectangle();
  static ArrayList<String> rules = new ArrayList<>();
  static Group root = new Group();
  public static void main(String[] args) throws Exception { launch(args); }
  @Override public void start(final Stage stage) throws Exception {        
    Line line = new Line();
    ArrayList<Line> linelist = new ArrayList<>();
    for(int i = 0; i < 22; i++){
        linelist.add(new Line());
        linelist.get(i).setStartX(i*20);
        linelist.get(i).setStartY(0.0f);
        linelist.get(i).setEndX(i*20);
        linelist.get(i).setEndY(420.0f);       
        root.getChildren().addAll(linelist.get(i));
    }
    for(int i = 0; i < 22; i++){
      linelist.add(new Line());
      linelist.get(i+22).setStartX(0.0f);
      linelist.get(i+22).setStartY(i*20);
      linelist.get(i+22).setEndX(420f);
      linelist.get(i+22).setEndY(i*20.0);        
      root.getChildren().addAll(linelist.get(i+22));
    }
    Rectangle r = new Rectangle(40,320,180,60);
    Rectangle r2 = new Rectangle(60,170,120,70);
    Ellipse ellipse = new Ellipse(280,120,75,60);
    CubicCurve cubic = new CubicCurve(180,420,190,380,190,330,80,340);
    cubic.setStroke(Color.FORESTGREEN);
    cubic.setStrokeWidth(4);
    cubic.setFill(Color.TRANSPARENT);
    CubicCurve cubic2 = new CubicCurve(100, 340,70,290,70,270,100,240);
    cubic2.setStroke(Color.FORESTGREEN);
    cubic2.setStrokeWidth(4);                                         
    cubic2.setFill(Color.TRANSPARENT);
    CubicCurve cubic3 = new CubicCurve(220,140,120,140,120,80,80,80);
    cubic3.setStroke(Color.FORESTGREEN);
    cubic3.setStrokeWidth(4);                                       
    cubic3.setFill(Color.TRANSPARENT);
    CubicCurve cubic4 = new CubicCurve(120,170,120,150,-40,120,80,80);
    cubic4.setStroke(Color.FORESTGREEN);
    cubic4.setStrokeWidth(4);                                       
    cubic4.setFill(Color.TRANSPARENT);
    CubicCurve cubic5 = new CubicCurve(290,60,290,60,340,20,340,0);
    cubic5.setStroke(Color.FORESTGREEN);
    cubic5.setStrokeWidth(4);
    cubic5.setFill(Color.TRANSPARENT);
    root.getChildren().addAll(cubic,cubic5,cubic2,cubic3,cubic4,r,r2,ellipse);
    robit.setFill(Color.BLUE);
    robit.setX(x*20);
    robit.setY(y*20);
    robit.setWidth(20);                                                                   
    robit.setHeight(20);
    root.getChildren().addAll(robit);
    Rectangle goal = new Rectangle();
    goal.setX(goalx*20);
    goal.setY(goaly*20);
    goal.setWidth(10);
    goal.setHeight(10);
    root.getChildren().addAll(goal);    
    Button b = new Button("do thing!");
    b.setOnAction(e -> {
        arrayToFX();
        root.getChildren().removeAll(r,ellipse,r2,cubic,cubic2,cubic3,cubic4,cubic5);        
        root.getChildren().addAll(cubic,cubic2,cubic3,cubic4,cubic5,r,ellipse,r2);
        if((x != goalx) || (y != goaly)) foreachmove();
        else robit.setFill(Color.RED); 
    });
    VBox vb = new VBox();
    vb.getChildren().addAll(root,b);
    filein();
    Scene scene1 = new Scene(vb, 700, 725, Color.ALICEBLUE);
    stage.setTitle("AI_PROJ1");
    stage.setScene(scene1);
    stage.show();
  }
public static void arrayToFX(){
    if(!yellowd){
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 22; j++){
                if(boardstate[i][j] == 1){
                    Rectangle r = new Rectangle();
                    r.setX(20*j);
                    r.setY(20*i);
                    r.setWidth(20);
                    r.setHeight(20);
                    r.setFill(Color.YELLOW);
                    root.getChildren().addAll(r);
                }
            }
        }
    }
    yellowd = true;
}
public static void filein(){
    try{
        Scanner input = new Scanner(new File(FILE));
        while(input.hasNextLine()){
            String line = input.nextLine();
            if(line.charAt(0) == '#') continue;
            else rules.add(line);
        }
    }
    catch(FileNotFoundException e){
    }
}
public static void foreachmove(){
    for(int i = 0; i < rules.size(); i++){
        if(rules.get(i).length() == 1){
            move(rules.get(i).charAt(0));
            System.out.println("defaulted");
            break;
        }
        char a = rules.get(i).charAt(0);
        char c = rules.get(i).charAt(2);
        if(rules.get(i).charAt(1)== '!'){
            if((space(a)) && (!space(c))){
                move(rules.get(i).charAt(3));
                break;
            }
        }
        else{
            if((space(a)) && (space(c))){
                move(rules.get(i).charAt(3));
                break;
            }       
        }
    }
}
public static boolean space(char n){
    int a = 0;
    if(n == '1') a = boardstate[y-1][x] + boardstate[y-1][x+1];
    if(n == '2') a = boardstate[y][x+1] + boardstate[y+1][x+1];
    if(n == '3') a = boardstate[y+1][x-1] + boardstate[y+1][x];
    if(n == '4') a = boardstate[y][x-1] + boardstate[y-1][x-1]; 
    System.out.println(n);
    System.out.println(a);
    System.out.print(boardstate[y-1][x-1]);
    System.out.print(boardstate[y-1][x]);
    System.out.println(boardstate[y-1][x+1]);
    System.out.print(boardstate[y][x-1]);
    System.out.print(" ");
    System.out.println(boardstate[y][x+1]);
    System.out.print(boardstate[y+1][x-1]);
    System.out.print(boardstate[y+1][x]);
    System.out.println(boardstate[y+1][x+1]);
    return (a != 0);
}
public static void move(char direction){
    if(direction == 'N') y-=1;
    if(direction == 'S') y+=1;
    if(direction == 'W') x-=1;
    if(direction == 'E') x+=1;
    root.getChildren().removeAll(robit);
    robit = new Rectangle();
    robit.setX(x*20);
    robit.setY(y*20);
    robit.setWidth(20);
    robit.setHeight(20);
    robit.setFill(Color.BLUE);
    root.getChildren().addAll(robit);
}
}
