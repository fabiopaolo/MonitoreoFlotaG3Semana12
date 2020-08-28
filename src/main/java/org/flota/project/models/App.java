package org.flota.project.models;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import java.util.Arrays;

public class App extends Application {

    private MapView mapView;

    public static void main(String[] args) {
        ArcGISRuntimeEnvironment.setInstallDirectory("/Users/tatsudy/Downloads/arcgis-runtime-sdk-java-100.8.0");
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        // set the title and size of the stage and show it
        stage.setTitle("Monitoreo");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        // create a MapView to display the map and add it to the stack pane
        mapView = new MapView();
        stackPane.getChildren().add(mapView);

        // create an ArcGISMap with the default imagery basemap
        ArcGISMap map = new ArcGISMap(Basemap.createImagery());

        // display the map by setting the map on the map view
        mapView.setMap(map);

        GraphicsOverlay graphicsOverlay = new GraphicsOverlay();
        mapView.getGraphicsOverlays().add(graphicsOverlay);

        Point point = new Point(-77.0844, -12.0561, SpatialReferences.getWgs84());
        Graphic pointGraphic = new Graphic(point, new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.DIAMOND, 0xFF0000FF, 14));

        graphicsOverlay.getGraphics().addAll(Arrays.asList(pointGraphic));
    }

    /**
     * Stops and releases all resources used in application.
     */
    @Override
    public void stop() {
        if (mapView != null) {
            mapView.dispose();
        }
    }
}