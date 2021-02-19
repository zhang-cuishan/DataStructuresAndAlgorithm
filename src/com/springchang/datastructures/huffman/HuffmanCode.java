package com.springchang.datastructures.huffman;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 哈夫曼编码
 * @author : 张翠山
 * @date 2021.02.17
 */
public class HuffmanCode {

    static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();

    static int zeroCount = 0;

    /**
     * 使用一个方法，将前面的方法封装起来，便于我们的调用.
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过 赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node root = createHuffmanTree(nodes);
        getCodes(root);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "Hello Java, This is Java Source String, Pelese decode here.";
        byte[] sourceBytes = huffmanZip(str.getBytes());
        System.out.println("huffmanCodeBytes = " + Arrays.toString(sourceBytes));
        byte[] jiema = decode(huffmanCodes, sourceBytes);
        System.out.println("new String(jiema) = " + new String(jiema));
    }

    /**
     *
     * @param bytes 接收字节数组
     * @return 返回的就是 List 形式   [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......],
     */
    private static List<Node> getNodes(byte[] bytes) {
        Map<Byte, Integer> hashMap = new HashMap<Byte, Integer>();

        for (byte b : bytes) {
            Integer count = hashMap.get(b);
            if(count == null) {
                hashMap.put(b, 1);
            } else {
                hashMap.put(b, count+1);
            }
        }

        List<Node> nodeList = new ArrayList<Node>();
        for (Map.Entry<Byte, Integer> entry : hashMap.entrySet()) {
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodeList;
    }

    /**
     * 可以通过List 创建对应的赫夫曼树
     * @param nodes nodes节点
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while(nodes.size() > 1) {
            Node leftNode = nodes.get(0);
            Node righNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.weight+righNode.weight);
            parentNode.left = leftNode;
            parentNode.right = righNode;

            nodes.remove(leftNode);
            nodes.remove(righNode);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    //为了调用方便，我们重载 getCodes
    private static void getCodes(Node root) {
        if(root == null) {
            return;
        }

        getCodes(root.left, "0", new StringBuilder());
        getCodes(root.right, "1", new StringBuilder());
    }

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
     * @param node  传入结点
     * @param code  路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder newStringBuilder = new StringBuilder(stringBuilder);
        newStringBuilder.append(code);
        if(node != null) {
            if(node.data == null) {
                getCodes(node.left, "0", newStringBuilder);
                getCodes(node.right, "1", newStringBuilder);
            } else {
                huffmanCodes.put(node.data, newStringBuilder.toString());
                return;
            }
        }
    }

    /**
     * 编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
     * @param bytes 这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();

        //拼接哈夫曼字符串
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //计算哈夫曼编码的字节数组长度
        int len = (stringBuilder.length()+7)/8;

        byte[] huffmanCodesByte = new byte[len];

        for (int i = 0, index = 0; i < stringBuilder.length(); i += 8) {
            String binaryValue = null;
            if(i+8 > stringBuilder.length()) {
                binaryValue = stringBuilder.substring(i);
                int j = i;
                while(j < stringBuilder.length()-1 && '0' == stringBuilder.charAt(j++)) {
                    zeroCount++;
                }
            } else {
                binaryValue = stringBuilder.substring(i, i + 8);
            }
            huffmanCodesByte[index++] = (byte) Integer.parseInt(binaryValue, 2);
        }

        return huffmanCodesByte;
    }

    /**
     * 将一个byte 转成一个二进制的字符串
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b; //将 b 转成 int
        //如果是正数我们还存在补高位
        if(flag) {
            temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if(flag) {
            return str.substring(str.length() - 8);
        } else {
            //补上缺失调的0
            Byte key = -1;
            while(zeroCount-->0) {
                str = "0"+str;
            }
            return str;
        }
    }

    /**
     * 编写一个方法，完成对压缩数据的解码
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            String temp = byteToBitString(!flag, b);
            stringBuilder.append(temp);
        }

        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte>  map = new HashMap<String,Byte>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for(int  i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while(flag) {
                String key = null;
                if(i+count <= stringBuilder.length()) {
                    key = stringBuilder.substring(i, i + count);//i 不动，让count移动，指定匹配到一个字符
                } else {
                    key = stringBuilder.substring(i);
                    flag = false;
                }
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for(int i = 0;i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;

    }


    private static class Node implements Comparable<Node> {
        Byte data;

        Integer weight;

        Node left;

        Node right;

        public Node(Byte data, Integer weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight ;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }
}
