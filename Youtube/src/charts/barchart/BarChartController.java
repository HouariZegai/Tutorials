package charts.barchart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BarChartController implements Initializable {
    
    @FXML
    private BarChart barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadBarChar();
    }   
    
    private void loadBarChar() {
        
        XYChart.Series xyJava = new XYChart.Series();
        XYChart.Series xyC = new XYChart.Series();
        XYChart.Series xyJS = new XYChart.Series();
        
        xyJava.setName("Java");
        xyC.setName("C");
        xyJS.setName("JS");
        
        xyJava.getData().add(new XYChart.Data<>("September", 20));
        xyC.getData().add(new XYChart.Data<>("September", 50));
        xyJS.getData().add(new XYChart.Data<>("September", 30));
        
        xyJava.getData().add(new XYChart.Data<>("October", 20));
        xyC.getData().add(new XYChart.Data<>("October", 10));
        xyJS.getData().add(new XYChart.Data<>("October", 80));
        
        xyJava.getData().add(new XYChart.Data<>("November", 15));
        xyC.getData().add(new XYChart.Data<>("November", 10));
        xyJS.getData().add(new XYChart.Data<>("November", 20));
        
        barChart.getData().addAll(xyJava, xyC, xyJS);
        
    }
    
    
    
}
