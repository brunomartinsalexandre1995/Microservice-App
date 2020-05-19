<template>
  <div id="arcade">
    <img class="arcade-logo" alt="Arcade logo" src="../assets/arcade.jpg">
    <div class="welcome-message">Welcome to my arcade App !</div>
    <div class="have-fun-message">You just have to choose a game and have fun !</div>
    <div id="games-container">
      <div>
        <div @click="goToMineWeeperPage">
          <img class="game-image" src="../assets/minesweeper.png">
        </div>
        <span class="game-description">Minesweeper</span>
      </div>
      <div>
        <div @click="goToFourInLinePage">
          <img class="game-image" src="../assets/4-in-line.jpg">
        </div>
        <span class="game-description">Four in line</span>
      </div>
      <div>
        <div @click="goToDraughtsPage">
          <img class="game-image" src="../assets/Damas-game.jpg">
        </div>
        <span class="game-description">Draughts</span>
      </div>
    </div>
  </div>

</template>

<script>
    export default {
        name: 'Homepage',
        methods: {
            goToMineWeeperPage() {
                window.location.href = 'minesweeper';
            },
            goToFourInLinePage() {
                window.location.href = 'four-in-line';
            },
            goToDraughtsPage() {
                window.location.href = 'draughts';
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
    color: white;
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
