# customcalender

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalenderViewModel = ViewModelProvider(this)[CalenderViewModel::class.java]
        val eventList = ArrayList<String>()


        setContent {
            MycalenderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val selectedDate = remember {
                        mutableStateOf("")
                    }
                    eventList.add("01/12/2023")
                    eventList.add("09/12/2023")
                    eventList.add("10/12/2023")
                    eventList.add("11/12/2023")
                    eventList.add("12/12/2023")
                    eventList.add("17/12/2023")
                    eventList.add("30/12/2023")
                    eventList.add("27/12/2023")
                    eventList.add("27/11/2023")
                    viewModel.createEvent(eventList)
                    viewModel.generateCalender()

                    LaunchedEffect(key1 = selectedDate.value, block = {
                        //do here
                        Log.e("selected date", "select date:" + selectedDate.value)
                    })
                    MainCalenderScreen(viewModel, selectedDate = selectedDate)
                }
            }
        }
    }
}
