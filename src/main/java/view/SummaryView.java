package view;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;
import data.SummaryData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class SummaryView extends JPanel {

    private JBTable table;
    private DefaultTableModel model;

    public SummaryView() {
        super();
        table = new JBTable();
        model = new DefaultTableModel(new Vector(), new Vector(Arrays.asList(new String[] {"Name", "Value"})));
        table.setModel(model);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        JBScrollPane scrollPane = new JBScrollPane(table);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateModel(List<SummaryData> summaries) {
        int noOfRows = model.getRowCount();
        for (int i = 0; i < noOfRows; i++) {
            model.removeRow(0);
        }
        for (SummaryData summary : summaries) {
            Vector row = new Vector();
            row.add(summary.getName());
            row.add(summary.getValue());
            model.addRow(row);
        }

    }
}
