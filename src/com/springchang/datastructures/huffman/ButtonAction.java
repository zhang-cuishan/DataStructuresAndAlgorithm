package com.springchang.datastructures.huffman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : 张翠山
 */
public class ButtonAction implements ActionListener {

    private HuffmanCode huffmanCode = null;

    private HuffmanCompressor huffmanCompressor = null;

    public ButtonAction(HuffmanCompressor huffmanCompressor) {
        this.huffmanCompressor = huffmanCompressor;
        huffmanCode = new HuffmanCode();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("开始".equals(e.getActionCommand())) {
            String sourceString = huffmanCompressor.chooseTextField.getText().trim();
            huffmanCode.huffmanZip(sourceString);
        } else if("停止".equals(e.getActionCommand())) {
            System.out.println("停止");
        } else {
            System.exit(0);
        }
    }
}
