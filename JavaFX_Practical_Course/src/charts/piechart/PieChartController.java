
package charts.piechart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;


public class PieChartController implements Initializable {
    
    @FXML
    private TextField name, value;
    @FXML
    private PieChart pieChart;
    
    private ObservableList<PieChart.Data> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        pieChart.setData(data);
    }
    
    @FXML
    private void btnAdd() {
        data.add(new PieChart.Data(name.getText(), Integer.valueOf(value.getText())));
        pieChart.setData(data);
    }
}