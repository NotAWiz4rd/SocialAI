package Entities;

/**
 * Created by notawiz4rd on 01.07.17.
 */
public class NeedSatisfaction
{
  private String needId;
  private int value;

  public NeedSatisfaction(String m_needId, int m_value)
  {
    needId = m_needId;
    value = m_value;
  }

  public String getNeedId()
  {
    return needId;
  }

  public void setNeedId(String needId)
  {
    this.needId = needId;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int value)
  {
    this.value = value;
  }
}
