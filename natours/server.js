const mongoose = require('mongoose');
const dotenv = require('dotenv');
dotenv.config({ path: './config.env' });

// listen to unchaught exceptions event
process.on('uncaughtException', (error) => {
  console.log('UNCAUGHT EXCEPTION! 💥 Shutting down...');
  console.log(error.name, error.message);
  process.exit(1);
});

const app = require('./app');
mongoose
  .connect(String(process.env.DATABASE), {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log('Database connection successfull'));

const port = process.env.PORT || 3000;
const server = app.listen(port, () => {
  console.log(`App running on port ${port}...`);
});

// listen to unhanlderRejection event
process.on('unhandledRejection', (error) => {
  console.log('UNHANDLER REJECTION! 💥 Shutting down...');
  console.log(error.name, error.message);

  // Shutting server gracefully to give to to finish the current promises before closing connection
  server.close(() => {
    process.exit(1);
  });
});
