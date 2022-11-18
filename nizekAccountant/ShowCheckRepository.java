/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.io.File;
import java.util.List;
import nizekAccountant.logic.ModelManager.Manager;
import nizekAccountant.logic.ConverterHelper.ConverterTime;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 * @author Lenovo
 */
public class ShowCheckRepository implements TableModel {

    UserRepository userRepository = new USerRepository();

    public ShowCheckRepository() {

    }

    @Override
    public int getRowCount() {
        return Manager.checkDocList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return "نام";
            }
            case 1 -> {
                return "مبلغ چک";
            }
            case 2 -> {
                return "وضعیت";
            }
            case 3 -> {
                return "تاریخ پاس";
            }
            case 4 -> {
                return "زمان ثبت";
            }
            case 5 -> {
                return "توضیحات";
            }

            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return false;
            }
            case 1, 3, 2, 4, 5 -> {
                return true;
            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                List<String> names;
                names = userRepository.readColumnWholeFile(0, new File(Manager.checkDocList.get(rowIndex).getFilePath()));
                return names.get(rowIndex);
            }
            case 1 -> {
                List<String> costs;
                costs = userRepository.readColumnWholeFile(1, new File(Manager.checkDocList.get(rowIndex).getFilePath()));
                return costs.get(rowIndex);
            }
            case 2 -> {
                List<String> statues;
                statues = userRepository.readColumnWholeFile(2, new File(Manager.checkDocList.get(rowIndex).getFilePath()));
                return CheckDoc.statusIsCashed(statues.get(rowIndex));
            }
            case 3 -> {
                List<String> dates;
                dates = userRepository.readColumnWholeFile(3, new File(Manager.checkDocList.get(rowIndex).getFilePath()));
                return ConverterTime.convertToPersian(dates.get(rowIndex));
            }
            case 4 -> {
                List<String> times;
                times = userRepository.readColumnWholeFile(4, new File(Manager.checkDocList.get(rowIndex).getFilePath()));
                return times.get(rowIndex);
            }
            case 5 -> { //fix this , this is discription
                 List<String> descriptions;
                descriptions = userRepository.readColumnWholeFile(5, new File(Manager.checkDocList.get(rowIndex).getFilePath()));
                return descriptions.get(rowIndex);
            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      switch (columnIndex) {
            case 0 -> {
               Manager.costumerList.get(rowIndex).setName((String) aValue);
            }
            case 1 -> {
                 Manager.checkDocList.get(rowIndex).setCost((String) aValue);
            }
            case 2 -> {
                Manager.checkDocList.get(rowIndex).setIsCashed((boolean) aValue);
            }
            case 3 -> {
                Manager.checkDocList.get(rowIndex).setDateNizek((DateNizek) aValue);
            }
            case 4 -> {
                Manager.checkDocList.get(rowIndex).setTimeNizek((TimeNizek) aValue);
            }
            case 5 -> {
                Manager.checkDocList.get(rowIndex).setDescription((String) aValue);
            }

            default -> throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        } 
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
