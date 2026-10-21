package Week_8.Assignment;
import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate getRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        SubscriptionPlan[] subscribers = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if (planType.equals("BASIC")) {
                subscribers[i] = new BasicPlan(name, startDate);
            } else if (planType.equals("STANDARD")) {
                subscribers[i] = new StandardPlan(name, startDate);
            } else if (planType.equals("PREMIUM")) {
                subscribers[i] = new PremiumPlan(name, startDate);
            }
        }
        System.out.println("\nSubscription Renewal Dates:\n");
        for (SubscriptionPlan sub : subscribers) {
            System.out.println(sub.getSubscriberName() + ": " + sub.getRenewalDate());
        }

        sc.close();
    }
}