<template>
  <div id="nav">
    <router-link to="/">Home - New note</router-link>|
    <router-link to="/about">All notes</router-link>
  </div>
  <router-view />

  <footer class="mt-5">
    <a href="https:github.com/elijahbus" target="blank" class="text-decoration-none">@elijahbus</a>
  </footer>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
  padding: 10px;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

footer a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
