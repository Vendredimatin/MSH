package ui.viewcontroller.salesman;

import bl.blfactory.BLFactoryImpl;
import blservice.orderblservice.OrderBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;
import ui.componentcontroller.order.*;
import ui.viewcontroller.client.ClientOrderViewController;
import util.OrderState;
import vo.OrderVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sorumi on 16/11/17.
 */
public class WebOrderListViewController {

    private static final int NUM_OF_CELL = 4;

    private WebOrderViewController webOrderViewController;

    @FXML
    private VBox contentVBox;

    private FXMLLoader[] cellLoaders = new FXMLLoader[NUM_OF_CELL];
    private Node[] cells = new Node[NUM_OF_CELL];

    private Node pagePane;
    private WebOrderPagePaneController webOrderPagePaneController;

    private OrderBLService orderBLService;

    private ArrayList<OrderVO> orders = new ArrayList<>();

    /**
     * Initializes the ClientOrderListViewController class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../component/order/WebOrderSearchPane.fxml"));
            VBox pane = loader.load();

            WebOrderSearchPaneController webOrderSearchPaneController = loader.getController();
            webOrderSearchPaneController.setWebOrderListViewController(this);

            contentVBox.getChildren().add(pane);


            FXMLLoader pageLoader = new FXMLLoader();
            pageLoader.setLocation(Main.class.getResource("../component/order/WebOrderPagePane.fxml"));
            pagePane = pageLoader.load();

            webOrderPagePaneController = pageLoader.getController();
            webOrderPagePaneController.setWebOrderListViewController(this);


            for (int i = 0; i < NUM_OF_CELL; i++) {
                FXMLLoader cellLoader = new FXMLLoader();
                cellLoader.setLocation(Main.class.getResource("../component/order/WebOrderCell.fxml"));
                HBox ordercell = cellLoader.load();

                cellLoaders[i] = cellLoader;
                cells[i] = ordercell;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        orderBLService = new BLFactoryImpl().getOrderBLService();


    }

    public void setWebOrderViewController(WebOrderViewController webOrderViewController) {
        this.webOrderViewController = webOrderViewController;
    }

    public void showOrders(OrderState orderState) {
        orders = orderBLService.searchOrder(orderState, null);
        int size = orders.size();
        webOrderPagePaneController.setPageCount(size/NUM_OF_CELL + ((size%NUM_OF_CELL == 0) ? 0 : 1));
        if (size > 0) {
            turnPage(1);
        } else {
            System.out.println("No Order");
        }

    }

    public void turnPage(int page) {
        int fromIndex = (page-1)*NUM_OF_CELL;
        int toIndex = Math.min(page*NUM_OF_CELL, orders.size());
        List<OrderVO> tmpOrders = orders.subList(fromIndex, toIndex);
        setCells(tmpOrders);
    }

    private void setCells(List<OrderVO> orders) {

        if (orders.size() > NUM_OF_CELL) {
            System.out.println("ERROR");
            return;
        }

        for (Node cell : cells) {
            contentVBox.getChildren().remove(cell);
        }

        contentVBox.getChildren().remove(pagePane);

        for (int i = 0; i < orders.size(); i++) {

            OrderVO order = orders.get(i);
            FXMLLoader loader = cellLoaders[i];
            Node ordercell = cells[i];

            WebOrderCellController webOrderCellController = loader.getController();
            webOrderCellController.setWebOrderListViewController(this);
            webOrderCellController.setOrder(order);

            contentVBox.getChildren().add(ordercell);
        }

        contentVBox.getChildren().add(pagePane);
    }

//    public void showClientOrderDetail(OrderVO order) {
//        clientOrderViewController.showClientOrderDetail(order);
//    }

}
