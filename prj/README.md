# ZOMBIE SURVIVAL

## type:
- Parser
- Statment
  - help
  - self
  - ask <Npc>
  - ask <Partner> use <Skill>
  - todo
  - <skill> <Monster>
  - pick <Coin | Weapon>
  - update <Weapon>
- Player
- Weapon
- Coin
- Npc
  - Partner
    - Elf
    - ZombieMaid == ZombieLeader
    - Mage
- Scene
  - Guild
  - LvTop
  - LvMid
  - LvFin
- Monster
  - Zombie
  - ZombieLeader
  - CrystalBot
  - Mage
  - Boss
- Skill

## Associations:

- Parser --generate-- Statment
- Player --read-- Statment
- Player --hit-- Monster
- Player --pick-- Coin
- Player --pick-- Weapon
    
uml:
```

                                 1                follow                               *
                                 +-----------------------------------------------------+
                                 |                                                     |
                                 |                                                     |
                                 |                                                     |
                                 |   1        update            *                      |
                                 |   +--------------------------+                      |
                                 +^  |                          ^                      |
+------+     +--------+*        1+---+--+1     pick        *+---+--+                   |
|Parser|     |Statment<----------+Player+------------------->Weapon|                   |
+------+     +--------+   read   +---+--+                   +------+                   |
  1|              ^*                 |                                                 |
   +--------------+                  |                                                 |
      generates                      |1    pick, use       *+----+                     |
                                     +---------------------^+Coin|                     |
                                     |                      +----+                     |
                                     |                                                 |
                                     |                                                 |
                                     |1    ask             *+---+                  +---+---+
                                     +---------------------^+Npc<------------------+Partner+--------+
                                     |                      +---+       extends    +-------+        |
                                     |                                                *^            |
                                     |                                                 |            |
                                     |1               ask...use                        |            |
                                     +-------------------------------------------------+            |
                                     |                                                 |            |
                                     |  learn                                          |            |can sometimes be
                                     +----------^------+        use (by player ask)    |            |
                                     |           |Skill+^------------------------------+            |
                                     +----------^------+                                            |
                                     |  use         |1                                              |
                                     |         apply|                                               |
                                     |              |1..*                                           |
                                     |           +--v----+                                          |
                                     |           |Monster+^-----------------------------------------+
                                     |           +-------+
                                     |
                                     |           +------+
                                     +----------^+Scene |
                                         in      +------+

```
