/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerxmlgit;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Attribute;

/**
 *
 * @author labin
 */
public class LerXML {

    public static void main(String[] args) throws JDOMException, IOException {

        File f = new File("C:\\Users\\labin\\Desktop\\exercicio 180517\\clientes.xml");
        //Criamos um objeto SAXBuilder
        // para ler o arquivo
        SAXBuilder sb = new SAXBuilder();
        //Criamos um objeto Document que
        // recebe o conteúdo do arquivo
        Document doc = sb.build(f);
        //Criamos um objeto Element que
        // recebe as tags do XML
        Element rootNode = doc.getRootElement();
        //Element cidade = rootNode.getChild("cidade");
        List list_cidade = rootNode.getChildren("cidade");

        cidade cid = new cidade();
        ArrayList<cidade> acidade = new ArrayList();

        for (int i = 0; i < list_cidade.size(); i++) {

            Element node = (Element) list_cidade.get(i);

            Attribute codigo = node.getAttribute("codigo");
            Attribute nome = node.getAttribute("nome");
            Attribute uf = node.getAttribute("uf");

            cid.setCodigo(Integer.parseInt(codigo.getValue()));
            cid.setNome(nome.getValue());
            cid.setUf(uf.getValue());

            acidade.add(cid);
        }

        for (cidade cidd : acidade) {
            System.out.println(cidd.getCodigo());
            System.out.println(cidd.getNome());
            System.out.println(cidd.getUf());
        }

    }
}
