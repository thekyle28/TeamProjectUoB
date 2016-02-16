package gui.movement;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FishMovement extends Application {
	/**
	    * Generate Path upon which animation will occur.
	    * 
	    * @param pathOpacity The opacity of the path representation.
	    * @return Generated path.
	    */
	   private Path generateCurvyPath(final double pathOpacity)
	   {
	      final Path path = new Path();
	      path.getElements().add(new MoveTo(0,20));
	      path.getElements().add(new CubicCurveTo(91, 93, 120, 140, 350, 13));
	      path.setOpacity(pathOpacity);
	      return path;
	   }

	   /**
	    * Generate the path transition.
	    * 
	    * @param shape Shape to travel along path.
	    * @param path Path to be traveled upon.
	    * @return PathTransition.
	    */
	   private PathTransition generatePathTransition(final Shape shape, final Path path)
	   {
	      final PathTransition pathTransition = new PathTransition();
	      pathTransition.setDuration(Duration.seconds(8.0));
	      pathTransition.setDelay(Duration.seconds(2.0));
	      pathTransition.setPath(path);
	      pathTransition.setNode(shape);
	      pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
	      pathTransition.setCycleCount(1);
	      return pathTransition;
	   }

	   /**
	    * Determine the path's opacity based on command-line argument if supplied
	    * or zero by default if no numeric value provided.
	    * 
	    * @return Opacity to use for path.
	    */
	   private double determinePathOpacity()
	   {
	      final List<String> parameters = new ArrayList<String>();
	      double pathOpacity = 1.0;
	      if (!parameters.isEmpty())
	      {
	         try
	         {
	            pathOpacity = Double.valueOf(parameters.get(0));
	         }
	         catch (NumberFormatException nfe)
	         {
	            pathOpacity = 0.0;
	         }
	      }
	      return pathOpacity;
	   }

	   /**
	    * Apply animation, the subject of this class.
	    * 
	    * @param group Group to which animation is applied.
	    */
	   private void applyAnimation(final Group group)
	   {
	      final Circle circle = new Circle(20, 20, 15);
	      circle.setFill(Color.DARKRED);
	      final Path path = generateCurvyPath(determinePathOpacity());
	      group.getChildren().add(path);
	      group.getChildren().add(circle);
	      group.getChildren().add(new Circle(20, 20, 5));
	      group.getChildren().add(new Circle(380, 240, 5));
	      final PathTransition transition = generatePathTransition(circle, path);
	      transition.play(); 
	      group.getChildren().remove(0);
	   }

	   /**
	    * Start the JavaFX application
	    * 
	    * @param stage Primary stage.
	    * @throws Exception Exception thrown during application.
	    */
	   @Override
	   public void start(final Stage stage) throws Exception
	   {
	      final Group rootGroup = new Group();
	      final Scene scene = new Scene(rootGroup, 600, 400, Color.GHOSTWHITE);
	      stage.setScene(scene);
	      stage.setTitle("JavaFX 2 Animations");
	      stage.show();
	      applyAnimation(rootGroup);
	   }

	   /**
	    * Main function for running JavaFX application.
	    * 
	    * @param arguments Command-line arguments; optional first argument is the
	    *    opacity of the path to be displayed (0 effectively renders path
	    *    invisible).
	    */
	   public static void main(final String[] arguments)
	   {
	      Application.launch(arguments);
	   }
}
