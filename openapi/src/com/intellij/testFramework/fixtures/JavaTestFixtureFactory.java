package com.intellij.testFramework.fixtures;

/**
 * @author yole
 */
public abstract class JavaTestFixtureFactory {
  private static final JavaTestFixtureFactory ourInstance;

  static {
    try {
      final Class<?> aClass = Class.forName("com.intellij.testFramework.fixtures.impl.JavaTestFixtureFactoryImpl");
      ourInstance = (JavaTestFixtureFactory)aClass.newInstance();
    }
    catch (Exception e) {
      throw new RuntimeException("Can't instnatiate factory", e);
    }
  }

  public static JavaTestFixtureFactory getFixtureFactory() {
    return ourInstance;
  }

  public abstract JavaCodeInsightTestFixture createCodeInsightFixture(IdeaProjectTestFixture projectFixture);
}
