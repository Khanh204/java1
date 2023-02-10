import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class BaiTap implements Initializable {

    public TextField tlPhone;
    public TextField txtName;
    public static TextField stPhone;
    public static TextField stName;
    public Text txtInfo;
    public ObservableList<Bai1> listNguoidung = FXCollections.observableArrayList();

    public static Bai1 editNguoidung;
    public TableView<Bai1> tbView;
    public TableColumn<Bai1,String> cName;
    public TableColumn<Bai1,String> cPhone;
    public TableColumn<Bai1, Button> cAction;


    public void submit(ActionEvent actionEvent) {
        String nn = txtName.getText();
        String tp = tlPhone.getText();

        if (editNguoidung == null){
            Bai1 s = new Bai1(nn, tp);
            listNguoidung.add(s);
        }else {
            for (Bai1 s : listNguoidung){
                if (s.ten.equals(editNguoidung.ten) && s.sdt.equals((editNguoidung).sdt)){
                    s.setTen(nn);
                    s.setSdt(tp);
                }
            }
        }
        tbView.setItems(listNguoidung);
        tbView.refresh();
        editNguoidung = null;
        clearInput();
    }
    void clearInput(){
        txtName.clear();
        tlPhone.clear();
    }
    public void edit(MouseEvent mouseEvent) {
       // editNguoidung = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editNguoidung.getTen());
        tlPhone.setText(editNguoidung.getSdt());
    }

//    private boolean az = true;
//    public void sort(ActionEvent actionEvent) {
//        az = !az;
//        Collections.sort(listNguoidung, new Comparator<Bai1>() {
//            @Override
//            public int compare(Bai1 o1, Bai1 o2) {
//                if (az) {
//                    return o1.ten.compareTo(o2.ten);
//                } else {
//                    return o2.ten.compareTo(o1.ten);
//                }
//            }
//        });
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("ten"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stName = txtName;
        stPhone = tlPhone;
    }
}