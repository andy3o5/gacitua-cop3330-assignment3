package Exercise43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.newBufferedWriter;

public class WebsiteGenerator
{

    private String siteName;
    private String author;
    private boolean createJavascriptFolder;
    private boolean createCssFolder;
    private Path mainFolder;


    public WebsiteGenerator(String siteName, String author, String pathName, boolean javascriptFolder, boolean cssFolder)
    {
        this.siteName = siteName;
        this.author = author;
        this.mainFolder = Paths.get(pathName +  "\\" + siteName.replace(" ", ""));
        this.createJavascriptFolder = javascriptFolder;
        this.createCssFolder = cssFolder;
    }

    public void createFolders() throws IOException
    {

        if(!Files.exists(mainFolder))
        {
            Files.createDirectories(mainFolder);
        }

        Path jsFolder = mainFolder.resolve("javascript");

        if (createJavascriptFolder && !Files.exists(jsFolder))
        {
            Files.createDirectories(jsFolder);
            }

        Path cssFolder = mainFolder.resolve("css");

        if(createCssFolder && !Files.exists(cssFolder))
        {
            Files.createDirectories(cssFolder);

    }
}

    public void generateHTMLIndexFile() throws IOException
    {
        try(BufferedWriter writer = newBufferedWriter(mainFolder.resolve("index.html"), Charset.forName("US-ASCII"),
                StandardOpenOption.CREATE))
                {

            String htmlTemplate =
                    "<!doctype html>\n" +
                            "\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "  <meta charset=\"utf-8\">\n" +
                            "  <title>" + siteName + "</title>\n" +
                            "  <meta name=\"" + author + "\">\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "   <p>This is an auto-generated website!</p>\n" +
                            "</body>\n" +
                            "</html>";
            writer.write(htmlTemplate);
        }
    }
}