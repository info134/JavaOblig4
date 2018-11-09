package app;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import app.DAOs.DAOAddress;
import app.DAOs.DAOCustomer;
import app.DAOs.DAOProduct;
import app.DAOs.InvoiceDAO;
import app.models.Address;
import app.models.Customer;
import app.models.Invoice;
import app.models.Product;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.util.Iterator;



public class AreaChartet {

    @FXML
    private AreaChart<Number, Number> areaChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;


    private Iterator<Product> pr = new DAOProduct().findall().iterator();


    public void startMe(Stage stage){

        areaChart.setTitle("Sum");
        xAxis.setLabel("Alle faktura");
        yAxis.setLabel("Totalt innkrevd");

    }

    public void graphMe(){

        if (pr.hasNext()) {
            Product prices = pr.next();

            XYChart.Series<Number, Number> series= new XYChart.Series<>();
            int sum = prices.getPrice();
        }
    }





}
