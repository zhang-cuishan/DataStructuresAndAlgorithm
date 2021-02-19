package com.springchang.datastructures.huffman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * 哈夫曼文件压缩软件
 * @author : 张翠山
 * @date 2020.02.17
 */
public class HuffmanCompressor extends JFrame {

    //方格的宽度和长度
    public static final int JFRAME_WIDTH = 380;

    public static final int JFRAME_HEIGHT = 400;

    public JButton startBtn = new JButton("压缩");

    public JButton unzipBtn = new JButton("解压");

    public JButton stopBtn = new JButton("停止");

    public JTextField chooseTextField = new JTextField("请选择要压缩的文件");

    public static void main(String[] args) {
        HuffmanCompressor huffmanCompressor = new HuffmanCompressor();
        huffmanCompressor.launch();
    }

    public void launch(){

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(JFRAME_WIDTH, 125));

        JPanel fileInputPanle = new JPanel();
        fileInputPanle.setPreferredSize(new Dimension(JFRAME_WIDTH, 60));

        JButton scannerButton = new JButton("浏览");

        chooseTextField.setPreferredSize(new Dimension(220, 20));

        fileInputPanle.add(chooseTextField);
        fileInputPanle.add(scannerButton);

        JFrame _this = this;

        scannerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(_this);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    chooseTextField.setText(file.getAbsolutePath());
                }else{
                    chooseTextField.setText("请选择文件/夹");
                }
            }
        });

        JPanel fileOutputPanle = new JPanel();
        fileOutputPanle.setPreferredSize(new Dimension(JFRAME_WIDTH, 60));

        fileOutputPanle.add(new JTextField("D:/A72.0/.net framework常用版本安装包"));
        fileOutputPanle.add(new JButton("另存为"));

        northPanel.add(fileInputPanle, BorderLayout.NORTH);
        northPanel.add(fileOutputPanle, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(JFRAME_WIDTH, 100));

        final JRadioButton config1 = new JRadioButton("配置1 - 这里是对配置1的解释", true);
        final JRadioButton config2 = new JRadioButton("配置2 - 这里是对配置2的解释");
        final JRadioButton config3 = new JRadioButton("配置3 - 这里是对配置3的解释");
        final JRadioButton config4 = new JRadioButton("配置4 - 这里是对配置4的解释");
        final JRadioButton config5 = new JRadioButton("配置5 - 这里是对配置5的解释");

        centerPanel.setLayout(new GridLayout(5, 1));
        centerPanel.add(config1);
        centerPanel.add(config2);
        centerPanel.add(config3);
        centerPanel.add(config4);
        centerPanel.add(config5);

        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(JFRAME_WIDTH, 100));
        southPanel.setLayout(new BorderLayout());

        JPanel progressPanel = new JPanel();
        progressPanel.add(new JProgressBar());
        progressPanel.add(new JLabel("完成"));
        southPanel.add(progressPanel, BorderLayout.NORTH);

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        startBtn.addActionListener(new ButtonAction(this));

        stopBtn.addActionListener(new ButtonAction(this));

        operationPanel.add(startBtn);
        operationPanel.add(stopBtn);

        southPanel.add(operationPanel, BorderLayout.CENTER);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setTitle("哈夫曼压缩算法");
        this.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.WHITE);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        this.setResizable(false);

        this.setVisible(true);
    }

}
