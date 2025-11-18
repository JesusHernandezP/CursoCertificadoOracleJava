package com.oracle.html5.demoframework;

import javax.servlet.ServletContext;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestDemoBuilder {

  @Mock
  ServletContext context;
  @InjectMocks
  DemoList demoList;

  @Before
  public void setup() {
    demoList = new DemoList();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldTestConstruction() {
    when(context.getResourceAsStream("/desc.info.json")).thenReturn(getClass().getResourceAsStream("root.desc.info.json"));
    when(context.getResourceAsStream("/lesson02/ex1/desc.info.json")).thenReturn(getClass().getResourceAsStream("ex1.desc.info.json"));
    when(context.getResourceAsStream("/lesson02/desc.info.json")).thenReturn(getClass().getResourceAsStream("list.desc.info.json"));
    demoList.init();
    final Demo folder = demoList.getDemos().get(0);
    final Demo item = folder.getDemos().get(0);
    DemoFile file = item.getFiles().get(0);
    assertEquals("lesson02/ex1/", item.getPath());
    assertEquals("/lesson02/ex1/index.html", file.getOriginalPath());
    //assertEquals("/modules/demos/lesson02/ex1/index.html", file.getLocalFilePath());
    assertEquals("/lesson02/ex1/solution/index.html", file.getSolutionPath());
    file = item.getFiles().get(1);
    assertNull(file.getSolutionPath());
    assertTrue(file.isHidden());
    file = item.getFiles().get(2);
    assertFalse(file.isHidden());
    assertNull(file.getSolutionPath());

    assertEquals("root", item.getFileViewRoot().getName());
    assertEquals("lesson02", item.getFileViewRoot().getFiles().get(0).getName());
    assertEquals("ex1", item.getFileViewRoot().getFiles().get(0).getFiles().get(0).getName());
    assertEquals("index.html", item.getFileViewRoot().getFiles().get(0).getFiles().get(0).getFiles().get(0).getName());
  }

  @Test
  public void shouldTestConstruction2() {
    when(context.getResourceAsStream("/desc.info.json")).thenReturn(getClass().getResourceAsStream("root2.desc.info.json"));
    demoList.init();
    final Demo lesson1 = demoList.getDemos().get(0);
    assertTrue(lesson1.getDemos().get(0).isPreviewHidden());
    assertTrue(lesson1.getDemos().get(1).isPreviewHidden());
    assertFalse(lesson1.getDemos().get(2).isPreviewHidden());
  }
}
