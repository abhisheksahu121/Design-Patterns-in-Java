package SolidPrinciple;

import java.util.ArrayList;
import java.util.List;
// import java.util.Objects;

// lets suppose we want to have some sort of application for modeling relationship between different people
enum Relationship
{
    PARENT,
    CHILD,
    SIBLING
}

class Person
{
    public String name;

    public Person(String name)
    {
        this.name = name;
    }
}

interface RelationshipBrowser
{
    List<Person> findAllChildrenOf(String name);
}

// its low-level because its related to data storage, it simply provides a list or 
// it keeps a list and it gives us some sort of access to that list and it does not have nay business logic.
// its simply allow us to manipulate the list and that it its single responsibillity priciple.
class Relationships implements RelationshipBrowser // low-level
{
    private List<Triplet<Person, Relationship, Person>> relations
     = new ArrayList<>();

     public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
     }
     public void addParentAndChild(Person parent, Person child)
     {
        // relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        // relations.add(new Triplet<>(child, Relationship.CHILD, parent));

     }
    // @Override
    // public List<Person> findAllChildrenOf(String name) {
    //     relations.stream()
    //     .filter(x -> Objects.equals(x.getValue0().name, name)
    //     && x.getValue1() == Relationship.PARENT)
    //     .map(Triplet :: getValue2).collect(Collectors.toList());
    @Override
    public List<Person> findAllChildrenOf(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllChildrenOf'");
    }
       
    // }
}

// its a high-level module, it allow is to perform some sort of operations on those
// low-level constructs and so it is a kind of higher to the end user, so to speack, because the end user doesn't really care
// they care about the actual research, they want the result.
class Research //high-level
{
    // public Research(Relationships relationships)
    // {
    //     List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
    //     relations.stream()
    //     .filter(x -> x.getValue0().name.equals("John")
    //     && x.getValue1() == Relationship.PARENT)
    //     .forEach(ch -> System.out.println(
    //         "John has a chils called " + ch.getValue2().name
    //     ));
    // }

    public Research(RelationshipBrowser browser)
    {
        List<Person> children = browser.findAllChildrenOf("John");
        for(Person child : children)
        System.out.println("John has a child called " + child.name);
    }
}
public class DIP {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
