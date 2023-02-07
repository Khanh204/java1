import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.Comparator;

public class BaiTap {

    public TextField tlPhone;
    public TextField txtName;
    public Text txtInfo;
    public ObservableList<Bai1> listNguoidung = FXCollections.observableArrayList();
    public ListView<Bai1> lv;
    public Bai1 editNguoidung;
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
        lv.setItems(listNguoidung);
        lv.refresh();
        editNguoidung = null;
        clearInput();
    }
    void clearInput(){
        txtName.clear();
        tlPhone.clear();
    }
    public void edit(MouseEvent mouseEvent) {
        editNguoidung = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editNguoidung.getTen());
        tlPhone.setText(editNguoidung.getSdt());
    }

    private boolean az = true;
    public void sort(ActionEvent actionEvent) {
        az = !az;
        Collections.sort(listNguoidung, new Comparator<Bai1>() {
            @Override
            public int compare(Bai1 o1, Bai1 o2) {
                if (az) {
                    return o1.ten.compareTo(o2.ten);
                } else {
                    return o2.ten.compareTo(o1.ten);
                }
            }
        });
    }
}