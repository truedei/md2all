package Test;

import com.youbenzi.mdtool.tool.MDTool;
import org.junit.Test;

public class TestMd {

    @Test
    public void test1(){
        String md = "# md2all\n" +
                "makdown to html,to pdf,to word,to all ....\n" +
                "\n" +
                "\n" +
                "\n" +
                "# 介绍\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "# 计划支持的功能\n" +
                "\n" +
                "\n" +
                "\n" +
                "- [ ] 1、makdown转html（优先级高）\n" +
                "- [ ] 2、makdown转pdf\n" +
                "- [ ] 3、makdown转word\n" +
                "- [ ] 4、RestfullAPI转makdown\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "# 可参考资料\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "**1、参考另外的开源项目:**\n" +
                "\n" +
                "```xml\n" +
                "       <!--makdown to html-->\n" +
                "        <dependency>\n" +
                "            <groupId>com.vladsch.flexmark</groupId>\n" +
                "            <artifactId>flexmark-all</artifactId>\n" +
                "            <version>0.50.42</version>\n" +
                "        </dependency>\n" +
                "\n" +
                "        <!--makdown to html-->\n" +
                "        <dependency>\n" +
                "            <groupId>com.youbenzi</groupId>\n" +
                "            <artifactId>MDTool</artifactId>\n" +
                "            <version>1.2.4</version>\n" +
                "        </dependency>\n" +
                "```\n";

        String html = MDTool.markdown2Html(md);

        System.out.println(html);
    }

    @Test
    public void test2(){
        String md = "# 这是一级标题";

        //调用其他人开源的一个makdown 2 html的工具
        String html = MDTool.markdown2Html(md);

        //添加table的样式
//        html = html.replace("<table>","<table border='1'>");

        System.out.println(html);
    }


    @Test
    public void test3(){
        String md = "\n" +
                "| a    | a    |\n" +
                "| ---- | ---- |\n" +
                "| cc   | bb   |\n" +
                "\n";

        String html = MDTool.markdown2Html(md);

        //添加table的样式
        html = addStyle(html,"<table>","<table border='1'>");
        html = addStyle(html,"<tr>","<tr style='background-color: red'>");


        System.out.println(html);
    }


    static public String addStyle(String html,String node,String style){
        return html.replace(node,style);
    }



    @Test
    public void test4(){
        String md = "#这是一级标题";

        //调用其他人开源的一个makdown 2 html的工具
        String html = MDTool.markdown2Html(md);

        String html2  = aa(md);

        System.out.println(html);
        System.out.println(html2);
    }

    static public String aa(String md){
        String s = "";

        //判断是否一级标题
        if(md.charAt(0) == '#'){
            s = "<h1>"+md.substring(1,md.length())+"</h1>";
        }

        return s;
    }

}
