package top.dainel.thunder.warning.dbscan;

import java.util.List;

public class Point {
    public int id; // 点的序列号
    public List<Double> location;// 点的坐标
    public int flag; // 0表示未处理，1表示处理了

   public Point(int id, List<Double> location, int flag) {
       this.id = id;
       this.location = location;
       this.flag = flag;
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public List<Double> getLocation() {
       return location;
   }

   public void setLocation(List<Double> location) {
       this.location = location;
   }

   public int getFlag() {
       return flag;
   }

   public void setFlag(int flag) {
       this.flag = flag;
   }

   @Override
   public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + flag;
       result = prime * result + id;
       result = prime * result
               + ((location == null) ? 0 : location.hashCode());
       return result;
   }

   @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       Point other = (Point) obj;
       if (flag != other.flag)
           return false;
       if (id != other.id)
           return false;
       if (location == null) {
           if (other.location != null)
               return false;
       } else if (!location.equals(other.location))
           return false;
       return true;
   }

   @Override
   public String toString() {
       return "Point [id=" + id + ", location=" + location + ", flag="
               + flag + "]";
   }
}