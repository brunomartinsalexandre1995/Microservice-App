<template>
  <div id="arcade">
    <div class="welcome-message">Welcome the Four In Line Game !</div>
  </div>
</template>

<script>
    export default {
        name: 'FourInLine',
        methods: {
            foo() {
                console.log('foo called')
            }
        }
    }
</script>

<style>

  .welcome-message {
    margin-top: 20px;
    font-size: 22px;
    font-weight: bold;
  }

  .have-fun-message {
    margin-bottom: 20px;
    font-size: 18px;
    font-weight: bold;
  }

  .game-description {
    margin-bottom: 16px;
    font-weight: bold;
  }

  .arcade-logo {
    width: 450px;
    height: 250px;
  }

  #arcade {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }

  #games-container {
    display: flex;
    flex-wrap: wrap;
    align-content: center;
    justify-content: center;
    width: 100%;
  }

  .game-image {
    width: 250px;
    height: 250px;
    margin: 15px;
    display: grid;
  }

</style>
