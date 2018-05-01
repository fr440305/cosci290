Lab 6
=====

Write some classes.

type Player class implements Hurtable {
  getHp,
  reduceHp,
  getPw,
  
}

type Hurtable abstract {
  getHp    void:int,
  reduceHp int:int,
}

type Enemy abstract extends Hurtable {
  hurtPlayer  Player:int
}

type ZombieSolider class implements Enemy
type ZombieBoss class implements Enemy





