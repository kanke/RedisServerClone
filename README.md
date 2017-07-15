# A program that mimics Redis Keys and String commands using Java Map # 
 Redis is a data structures server, supporting different kinds of values. What this means is that, while in traditional key-value stores you associated string keys to string values, in Redis the value is not limited to a simple string, but can also hold more complex data structures.
Redis keys commands are used for managing keys in Redis and Redis strings commands are used for managing string values in Redis.

## Commands Supported: ##

All errors are handled and it you type a command that is incomplete, you get the message - *"ERROR: not enough parameters"*

>**EXISTS** - Usage: EXISTS key 
          --> command returns "1 - It exists\!" or "2 - It doesn't exist\!" to signal if a given key exists or not.

>**DEL** - Usage: DEL key
       --> This command deletes the key, if it exists. Prints OK if the key was removed.

>**GET** - Usage: GET key
       --> Gets the value of a key.
       
>**SET** - Usage: SET key value
       --> This command sets the value at the specified key.
       
>**EXPIRE** - Usage: EXPIRE key seconds
          --> Sets the expiry of the key after the specified time.


![Running Redis Server code](/test.png)
### Further Reading ### 

[Redis Expire command](https://redis.io/commands/expire)

[Redis data type introduction](https://redis.io/topics/data-types-intro)

#### NOTE: #### 
Program is not concurrent and the problem statement explicitly stated not to use locks.