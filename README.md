# JPASecondDay

Java Persistance API

Object Relation Mapping

Table to Object

Hibernate
Open Source Java ORM Tool

Entitet bukvalno predstavlja tabele
get/set           Service je logic


@Entity -POJO
@id gde u bazi je ID
@GeneratedValue -> autoincrement
@Column
@JoinColumn
@OnetoMany
@ManyToOne
@ManyToMany
@Transient - will be removed from mapping because it does nto exist in a table


JPA meta-inf/persistence.xml

@Table

OneToMany: Lazy
ManyToOne: Eager
ManyToMany: Lazy
OneToOne: Eager       This is changable but default


Person OneToMany  1 -----------------* Car ManyToOne


+JoinColumn


LazyLoading Person.getCar za svaki on poziva posebno. Related items are not retrieved until they are first accessed

Eager povuce i Person i Car tj. i njeove reference

Polymorph

Cascade - Tells Hibernate whether to follow the path of relationship on Insert/Update/Delete(i think)


JPA Course2

Embeddable Objects

@Embeddable
@Embedded

Mozemo grupisati ako nemamo tabelu address a nemamo napravimo object i ubacimo

Batch processing - data will be saved in case of failure

Inheritance

Person [Name, lName] 
-----> Patient[insured]
-----> Doctor[acredited] 
This is a IS-A relationship 

EmbeddedId

Generise se novi entitet

[]1----*[foreign key]*----1[]
generise se novi entitet da bi se povezale dve tabele? (valjda)

