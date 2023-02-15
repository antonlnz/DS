package e2;

import java.util.PriorityQueue;

public class Personal implements Observer {
   PriorityQueue<Warning> queue;

   public Personal() {
      this.queue = new PriorityQueue<>(new MyComparator());
   }

    @Override
    public void update(Subject s) {
       Warning aux = (Warning) s;
       if(queue.contains(aux)){
           removeFromWarningQueue(aux);
           addToWarmingQueue(aux);
       }
       else
           addToWarmingQueue(aux);
    }

   public void addToWarmingQueue(Warning warning) {
      this.queue.add(warning);
   }

   public void removeFromWarningQueue(Warning warning) {
      this.queue.remove(warning);
   }

   public void informe(Tank tank) {
       System.out.println("Alertas de Mantenimiento " + tank.getName());

       for(Warning aux = queue.peek(); !queue.isEmpty(); removeFromWarningQueue(aux)){
           System.out.println("* Alerta " + aux.getColor().toString());
           System.out.println("Tanque de las " + tank.getName() + ", " + tank.getUbication());
           System.out.println("Control de " + aux.getSensor().getName() + " " + tank.getName() + " parámetro " + aux.getSensor().getName() + ", nivel" + tank.getLevel());
           System.out.println("Hora " + aux.getHour().toString() + " dia " + aux.getDate().toString());
       }

   }

    public boolean deleteQueue(Personal personal) {
        do {
        queue.remove();
        }
        while(queue.size()>0);
        return true;
    }

}