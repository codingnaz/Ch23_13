import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Ch23_13 extends Application {
    ArrayList<Points> pointlist = new ArrayList<Points>();

    public class Points{
        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        double x;
        double y;
        Points(double x, double y){
            this.x=x;
            this.y=y;


        }
    }

    public Pane pane = new Pane();

    /*public void Start(){
        for (int i=0; i<3;i++){
            double dotX= Math.random() * 118;
            double dotY= Math.random() * 118;
            Circle circle = new Circle(4);
            circle.setTranslateX(dotX);
            circle.setTranslateY(dotY);
            pointlist.add(new  Points(dotX,dotY));

        }
    }*/
    public void addPoints(double x,double y){

    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(pane, 350, 200);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();




        scene.setOnMouseClicked(e -> {
            Circle circle = new Circle(4);
            Line line= new Line() ;
            if (e.getButton() == MouseButton.PRIMARY) {


                pointlist.add(new Points(e.getX(),e.getY()));
                circle.setTranslateX(e.getX());
                circle.setTranslateY(e.getY());
                pane.getChildren().addAll(circle);
                for(int i=0;i< pointlist.size();i++){
                    System.out.print(i+" X : "+pointlist.get(i).getX());
                    System.out.println(" Y : "+pointlist.get(i).getY());
                }
            } else if (e.getButton() == MouseButton.SECONDARY) {
                for(int i=0;i< pointlist.size();i++){
                    if(e.getX()==pointlist.get(i).getX()){
                        pointlist.remove(i);
                        circle.setTranslateX(e.getX());
                        circle.setTranslateY(e.getY());
                        //pane.getChildren().remove(circle.setTranslateX(e.getX()));
                    }
                }
                for(int i=0;i< pointlist.size();i++){
                    System.out.print(i+" X : "+pointlist.get(i).getX());
                    System.out.println(" Y : "+pointlist.get(i).getY());
                }

            }

        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}